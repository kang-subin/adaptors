package com.multitap.aifeedback.application.service;

import com.multitap.aifeedback.adaptor.out.ocr.presentation.OcrProcessingService;
import com.multitap.aifeedback.application.mapper.OcrDtoMapper;
import com.multitap.aifeedback.application.port.in.dto.in.OcrInputImageDto;
import com.multitap.aifeedback.application.port.in.dto.in.OcrProcessedFeedbackRequest;
import com.multitap.aifeedback.application.port.in.dto.in.OcrRequestDto;
import com.multitap.aifeedback.application.port.in.OcrUseCase;
import com.multitap.aifeedback.application.port.in.dto.out.OcrResponseDto;
import com.multitap.aifeedback.application.port.out.OcrApiPort;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OcrService implements OcrUseCase {

    private final OcrApiPort ocrApiPort;
    private final OcrProcessingService ocrProcessingService;

    @Override
    public OcrProcessedFeedbackRequest uploadPdfForOcr(OcrRequestDto ocrRequestDto) throws IOException {

        // 이미지 분석
        List<OcrResponseDto> ocrResponses = ocrApiPort.callOcrApi(convertPdfToImages(ocrRequestDto));

        // OCR 결과 데이터 파싱
        return ocrProcessingService.parseOcrResponses(ocrResponses);

    }


    // pdf 파일 이미지화
    public OcrInputImageDto convertPdfToImages(OcrRequestDto ocrRequestDto) throws IOException {

        List<File> imageFiles = new ArrayList<>();

        // 임시 디렉토리 생성
        Path tempDir = Files.createTempDirectory("ocr-");
        PDDocument document = PDDocument.load(ocrRequestDto.getFile().getInputStream());
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        for (int pageIndex = 0; pageIndex < document.getNumberOfPages(); pageIndex++) {
            // 페이지를 300 DPI 해상도로 이미지로 변환
            BufferedImage image = pdfRenderer.renderImageWithDPI(pageIndex, 300);  // 300 DPI로 설정

            // 임시 파일로 저장
            Path tempImagePath = tempDir.resolve("page_" + pageIndex + ".png");
            File tempImageFile = tempImagePath.toFile();
            ImageIO.write(image, "PNG", tempImageFile);  // PNG 형식으로 저장
            imageFiles.add(tempImageFile);
        }

        document.close();

        return OcrDtoMapper.from(imageFiles);
    }

}