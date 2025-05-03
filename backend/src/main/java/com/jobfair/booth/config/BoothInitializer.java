package com.jobfair.booth.config;

import com.jobfair.booth.model.Booth;
import com.jobfair.booth.repository.BoothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BoothInitializer implements CommandLineRunner {

    private final BoothRepository boothRepository;

    @Override
    public void run(String... args) throws Exception {
        if (boothRepository.count() == 0) {
            List<Booth> booths = List.of(
                    createBooth("부스 A", "AI 직무 상담 부스"),
                    createBooth("부스 B", "IT 기업 채용 상담 부스"),
                    createBooth("부스 C", "해외 취업 설명 부스"),
                    createBooth("부스 D", "자기소개서 첨삭 부스"),
                    createBooth("부스 E", "인사담당자 면접 피드백 부스")
            );
            boothRepository.saveAll(booths);
            System.out.println("초기 부스 5개가 등록되었습니다.");
        } else {
            System.out.println("부스가 이미 존재합니다. 초기화 생략");
        }
    }

    private Booth createBooth(String name, String description) {
        Booth booth = new Booth();
        booth.setName(name);
        booth.setDescription(description);
        return booth;
    }
}
