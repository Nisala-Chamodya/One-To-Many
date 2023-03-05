import lk.onetomany.entity.Owner;
import lk.onetomany.entity.Pet;
import lk.onetomany.util.FactoryConfiguaration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AppInitializer {
    public static void main(String[] args) {

        Owner owner1  = new Owner();
        owner1.setoId("o001");
        owner1.setName("Tharani");


        Pet pet1 = new Pet();
        pet1.setpId("p001");
        pet1.setName("cat");
        pet1.setOwner(owner1 );


        Pet pet2 = new Pet();
        pet2.setpId("p002");
        pet2.setName("dog");
        pet2.setOwner(owner1 );


        //1 st step
        ArrayList<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        owner1.setPetList(petList);

        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        session.save(owner1);
        session.save(pet1);
        session.save(pet2);

        transaction.commit();
        session.close();


    }
}
