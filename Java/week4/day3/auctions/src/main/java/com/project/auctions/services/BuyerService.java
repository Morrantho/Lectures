package com.project.auctions.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.auctions.models.Buyer;
import com.project.auctions.repositories.BuyerRepository;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class BuyerService{
	@Autowired
	private BuyerRepository buyerRepository;

	public void create(Buyer buyer){
		String hash = BCrypt.hashpw(buyer.getPassword(),BCrypt.gensalt());
		buyer.setPassword(hash);
		buyerRepository.save(buyer);
	}

	public List<Buyer> findAll(){
		return buyerRepository.findAll();
	}

	public Buyer findOne(Long id){
		return buyerRepository.findOne(id);
	}

	public Buyer findByEmail(String email){
		return buyerRepository.findByEmail(email);
	}

	public void update(Buyer buyer){
		buyerRepository.save(buyer);
	}

	public void destroy(Long id){
		buyerRepository.delete(id);
	}

	public Buyer login(String email,String password){
		Buyer buyer = findByEmail(email);

		if(buyer != null){
			if( BCrypt.checkpw(password, buyer.getPassword() ) ){
				return buyer;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}