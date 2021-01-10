package org.choi.restapi.todolists;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<Todolist,Long> {
}
