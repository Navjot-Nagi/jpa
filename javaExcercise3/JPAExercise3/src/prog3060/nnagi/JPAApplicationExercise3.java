package prog3060.nnagi;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAApplicationExercise3 {
	
	static final String PERSISTENCE_UNIT_NAME = "Exercise3JPAApplication";

	public static void main(String[] args)
	{		
		EntityManagerFactory tempEntityManagerFactory = null;
        EntityManager tempEntityManager = null;
		// TODO Auto-generated method stub
		try
		{
			tempEntityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            tempEntityManager = tempEntityManagerFactory.createEntityManager();
            tempEntityManager.getTransaction().begin();
            
            String tempJPQLQuery = "SELECT h, ga, cy, ht, hs, har, he, ti from HouseHold h "
            						+"JOIN h.geographicArea ga "
            						+"JOIN h.censusYear cy "
            						+"JOIN h.houseHoldType ht "
            						+"JOIN h.houseHoldSize hs "
            						+"JOIN h.houseHoldsByAgeRange har "
            						+"JOIN h.houseHoldEarners he "
            						+"JOIN h.totalIncome ti "
            						+"where ga.alternativeCode = :alternativeCode "
            						+"AND cy.censusYear = :censusYear "
            						+"AND ht.description = :HouseHoldType "
            						+"AND hs.description = :HouseHoldSize "
            						+"AND har.description = :HouseHoldsByAgeRange "
            						+"AND he.description = :HouseHoldEarners "
            						+"AND ti.description = :TotalIncome";
            
            //HouseHold tempHouseHold = tempEntityManager.find(HouseHold.class, 1 );
            
            List<HouseHold> result = tempEntityManager.createQuery(tempJPQLQuery).getResultList();
            
            //Create new geographic area
            GeographicArea tempGeographicArea = new GeographicArea();
            tempGeographicArea.setCode(60);
            tempGeographicArea.setLevel(1);
            tempGeographicArea.setName("Bharat");
            tempGeographicArea.setAlternativeCode(60);
            
            tempEntityManager.persist(tempGeographicArea);
            tempEntityManager.getTransaction().commit();

            
             GeographicArea hGeoArea = tempEntityManager.find(GeographicArea.class,tempGeographicArea.getGeographicAreaID());
            CensusYear hCensusYear = tempEntityManager.find(CensusYear.class,1);
            HouseHoldType hHouseHoldType = tempEntityManager.find(HouseHoldType.class, 11);
            HouseHoldSize hHouseHoldSize = tempEntityManager.find(HouseHoldSize.class, 3);
            HouseHoldsByAgeRange hHouseHoldsByAgeRange = tempEntityManager.find(HouseHoldsByAgeRange.class, 7);
            HouseHoldEarners hHouseHoldsEarners = tempEntityManager.find(HouseHoldEarners.class, 3);
            TotalIncome hTotalIncome = tempEntityManager.find(TotalIncome.class, 14);
            
            HouseHold tempHouseHold = new HouseHold();
			tempHouseHold.setGeographicArea(hGeoArea);
			tempHouseHold.setCensusYear(hCensusYear);
			tempHouseHold.setHouseHoldType(hHouseHoldType);
			tempHouseHold.setHouseHoldSize(hHouseHoldSize);
			tempHouseHold.setHouseHoldsByAgeRange(hHouseHoldsByAgeRange);
			tempHouseHold.setHouseHoldEarners(hHouseHoldsEarners);
			tempHouseHold.setTotalIncome(hTotalIncome);
			tempEntityManager.persist(tempHouseHold);

			String houseHoldQuery = "h From HouseHold h " + "Where h.id = :createdHouseHold";
			Query hHoldQuery = tempEntityManager.createQuery(houseHoldQuery);
			hHoldQuery.setParameter("createdHouseHold", tempHouseHold.getId());
			List<Object[]> tempList = hHoldQuery.getResultList();
			Iterator<Object[]> iteratorDataPoint = tempList.iterator();
			Object obj;
			HouseHold houseHold = new HouseHold();

			while (iteratorDataPoint.hasNext()) {
				obj = iteratorDataPoint.next();
				houseHold = (HouseHold) obj;
				System.out.println("Census Year " + houseHold.getCensusYear().getCensusYear());
				System.out.println("Geographic area name " + houseHold.getGeographicArea().getName());
				System.out.println("Geographic area code " + houseHold.getGeographicArea().getCode());
				System.out.println("Geographic area level " + houseHold.getGeographicArea().getLevel());
				System.out.println("Geographic area alternative code " + houseHold.getGeographicArea().getAlternativeCode());
				System.out.println("House holds reported satisfying above the criteria" + houseHold.getNumberReported());
				System.out.println();
			}
		}

		catch(Exception e)
		{
			if (tempEntityManager != null)
            {

                tempEntityManager.getTransaction().rollback();

            }

            e.printStackTrace();
			
		}
		finally
		{
			if (tempEntityManager != null)
            {

                tempEntityManager.close();

            }

            if (tempEntityManagerFactory != null)
            {

                tempEntityManagerFactory.close();

            }
		}
		

	}

}
