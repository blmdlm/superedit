package service;

import java.util.List;

import model.Magazine;
import model.Publisher;

/**
 * 
 * @author jym
 *
 */
public interface MagazineService {

	public Magazine get(int id);
	
	public List<Magazine> getByPublisher(Publisher publisher);
}
