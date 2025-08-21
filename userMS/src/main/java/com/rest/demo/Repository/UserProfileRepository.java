package com.rest.demo.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.demo.Entity.UserProfile;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Integer>{
	
	@Query(value="select * from ftr_user where personal_identification_number = ?1", nativeQuery=true)
	List<UserProfile> findByPersonalIdentificationNumber(Long PersonalIdentificationNumber);
	
	@Query(value="select * from ftr_user where user_id=?1",nativeQuery=true)
	List<UserProfile> findByUserId(int userId);
	
	
	@Modifying
	@Transactional
	@Query(value="update ftr_user set mobile_number=?1,permanent_address=?2,office_address=?3 where user_id=?4",nativeQuery=true)
	public Integer updatedetails(Long mobilenumber,String permanentaddress,String officeaddress,int userid);
	
	@Query(value="select * from ftr_user where email_id=?1",nativeQuery=true)
	List<UserProfile> findByEmailId(String emailId);

}
