package org.duffy.ex02.repository;

import org.duffy.ex02.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    private MemoRepository memoRepository;

    @Test
    public void testClass(){
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies(){

        IntStream.rangeClosed(0, 100).forEach( i-> {
            Memo memo = Memo.builder().memoText("Sample..."+i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void testSelect(){

        Long mno = 100L;

        List<Memo> result = memoRepository.findAll();

        if(!result.isEmpty()){
            result.forEach( i -> {
                Memo memo = i;
                System.out.println(memo);
            });
        }
    }
    
}
