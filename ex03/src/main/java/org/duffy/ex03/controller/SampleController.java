package org.duffy.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.duffy.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex01")
    public void ex01(){

        log.info("ex01.........");
    }

    @GetMapping("/ex02")
    public void exModel(Model model){

        List<SampleDTO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj( i -> {
            SampleDTO sampleDTO = SampleDTO.builder().sno(i)
                    .first("First "+i)
                    .last("Last "+i)
                    .regTime(LocalDateTime.now())
                    .build();
            return sampleDTO;
        }).collect(Collectors.toList());

        model.addAttribute("list", list);
    }

    @GetMapping("/exInline")
    public String exInline(RedirectAttributes redirectAttributes){

        log.info("exInline........");

        SampleDTO sampleDTO = SampleDTO.builder().sno(100L).first("first..100").last("last..100").regTime(LocalDateTime.now()).build();

        if (sampleDTO != null) {
            redirectAttributes.addFlashAttribute("result", "success");
        } else {
            redirectAttributes.addFlashAttribute("result", "false");
        }
        redirectAttributes.addFlashAttribute("dto", sampleDTO);

        return "redirect:/sample/ex03";
    }

    @GetMapping("/ex03")
    public void ex03(){

        log.info("ex03........");
    }

    @GetMapping("/exLayout01")
    public void exLayout01(){

        log.info("layout01...........");
    }
}
