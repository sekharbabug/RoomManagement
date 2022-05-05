package com.room.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.room.management.model.MemberDetails;
import com.room.management.repository.MemberRepository;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberRepository memberRepository;

	@PostMapping("/addmember")
	public ResponseEntity<MemberDetails> createMemeber(@RequestBody MemberDetails mbDetails) {

		try {
			MemberDetails mdetails = memberRepository.save(mbDetails);
			return new ResponseEntity<>(mdetails, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updatemember/{memberid}")
	public ResponseEntity<MemberDetails> updateMember(@PathVariable("memberid") int mid,
			@RequestBody MemberDetails mbdetails) {
		
		Optional<MemberDetails> mdetails = memberRepository.findById(mid);

		if (mdetails.isPresent()) {
			MemberDetails memberdetails = mdetails.get();
			memberdetails.setName(mbdetails.getName());
			memberdetails.setAge(mbdetails.getAge());
			memberdetails.setGender(mbdetails.getGender());
			memberdetails.setMobileno(mbdetails.getMobileno());
			memberdetails.setAadharno(mbdetails.getAadharno());
			memberdetails.setAddress(mbdetails.getAddress());
			return new ResponseEntity<>(memberRepository.save(memberdetails), HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/deletemember/{memberid}")
	public ResponseEntity<HttpStatus> deleteMember(@PathVariable("memberid") int memberid) {
		try {
			memberRepository.deleteById(memberid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteallmemebers")
	public ResponseEntity<HttpStatus> deleteAll() {
		try {
			memberRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getallmemebers")
	public ResponseEntity<List<MemberDetails>> getAllMembers() {
		try {
			List<MemberDetails> memberDetailsList = memberRepository.findAll();
			return new ResponseEntity<>(memberDetailsList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getmemberdetails/{memberid}")
	public ResponseEntity<MemberDetails> getMemberDetailsById(@PathVariable("memberid") int memeberid) {

		Optional<MemberDetails> mdetails = memberRepository.findById(memeberid);
		if (mdetails.isPresent()) {
			return new ResponseEntity<>(mdetails.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
