package org.duffy.ex02.repository;

import org.duffy.ex02.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

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
    public void testSelectAll(){

        List<Memo> result = memoRepository.findAll();

        if(!result.isEmpty()){
            result.forEach( i -> {
                Memo memo = i;
                System.out.println(memo);
            });
        }
    }

    @Test
    @Transactional
    public void testSelectById(){

        Long mno = 100L;

        Optional<Memo> memo = memoRepository.findById(mno);

        System.out.println("========================");
        if(memo.isPresent())
            System.out.println(memo);
        else
            System.out.println("not present.....");
    }

    @Test
    public void testUpdate(){

        Memo memo = Memo.builder().mno(99L).memoText("Update Text").build();

        System.out.println(memoRepository.save(memo));
    }

    @Test
    public void testDelete(){

        Long mno = 100L;

        memoRepository.deleteById(mno);
    }

    @Test
    public void testPageDefault(){

        Pageable pageable = PageRequest.of(11, 10);

        Page<Memo> result = memoRepository.findAll(pageable);

        System.out.println("========Result=========");
        System.out.println(result);

        System.out.println("========Result Info=========");
        System.out.println("Total Pages: "+result.getTotalPages());
        System.out.println("Total Elements Count: "+result.getTotalElements());
        System.out.println("Page Number: "+result.getNumber());
        System.out.println("Page Size: "+ result.getSize());
        System.out.println("Has next Page?: "+ result.hasNext());
        System.out.println("Is First Page?: "+ result.isFirst());

        System.out.println("========Data=========");
        result.forEach(System.out::println);
    }


}
