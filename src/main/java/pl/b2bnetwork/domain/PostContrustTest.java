package pl.b2bnetwork.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.b2bnetwork.repository.PartRepository;

import javax.annotation.PostConstruct;

@Component
public class PostContrustTest {

    @Autowired
    PartRepository partRepository;

    @PostConstruct
    public void test(){
        Part part=new Part();
        part.setName("postkontrast");
        part.setYearProducion(2222222);
        partRepository.save(part);
    }
}
