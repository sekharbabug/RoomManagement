package com.room.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.room.management.model.MemberDetails;

public interface MemberRepository extends JpaRepository<MemberDetails, Integer>{

}
