package org.duffy.ex02.repository;

import org.duffy.ex02.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> { }
