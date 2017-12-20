package com.fastspring.excercise.FastSpringAPI.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastspring.excercise.FastSpringAPI.domain.StoreSession;
@Repository
public interface IStoreSessionRepo extends JpaRepository<StoreSession, Serializable> {

}
