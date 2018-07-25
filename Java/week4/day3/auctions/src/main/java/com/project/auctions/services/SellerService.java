package com.project.auctions.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.auctions.models.Seller;
import com.project.auctions.repositories.SellerRepository;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

@Service
public class SellerService{
	@Autowired
	private SellerRepository sellerRepository;

	public void create(Seller seller){
		String hash = BCrypt.hashpw(seller.getPassword(),BCrypt.gensalt());
		seller.setPassword(hash);
		sellerRepository.save(seller);
	}

	public List<Seller> findAll(){
		return sellerRepository.findAll();
	}

	public Seller findOne(Long id){
		return sellerRepository.findOne(id);
	}

	public void update(Seller seller){
		sellerRepository.save(seller);
	}

	public void destroy(Long id){
		sellerRepository.delete(id);
	}

	public Seller findByEmail(String email){
		return sellerRepository.findByEmail(email);
	}

	public Seller login(String email,String password){
		Seller seller = findByEmail(email);

		if(seller != null){
			if( BCrypt.checkpw(password, seller.getPassword() ) ){
				return seller;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}