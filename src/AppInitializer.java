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

        Owner owner2  = new Owner();
        owner2.setoId("o002");
        owner2.setName("uchithma");


        Pet pet1 = new Pet();
        pet1.setpId("p001");
        pet1.setName("cat");
        pet1.setOwner(owner1 );


        Pet pet2 = new Pet();
        pet2.setpId("p002");
        pet2.setName("dog");
        pet2.setOwner(owner1 );


        Pet pet3 = new Pet();
        pet3.setpId("p003");
        pet3.setName("rabbit");
        pet3.setOwner(owner2 );


        Pet pet4 = new Pet();
        pet4.setpId("p004");
        pet4.setName("bird");
        pet4.setOwner(owner2 );


        //1 st step
        ArrayList<Pet> petList = new ArrayList<>();
        petList.add(pet1);
        petList.add(pet2);

        owner1.setPetList(petList);



        //2nd step
        owner2.getPetList().add(pet3);
        owner2.getPetList().add(pet4);


        Session session = FactoryConfiguaration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        session.save(owner2);
        session.save(pet3);
        session.save(pet4);

        transaction.commit();
        session.close();


    }
}
