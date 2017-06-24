package ict4315.assignment10;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PhoneUnitTests.class, ValidateInputUnitTests.class,
	ContactUnitTests.class, ContactListUnitTests.class, PhoneTypeUnitTests.class,
	USStatesUnitTests.class})
public class AllUnitTests 
{

}
