package com.basic.persitance.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.persitance.model.common.State;

public interface StateRepo extends JpaRepository<State, Long> {

}
