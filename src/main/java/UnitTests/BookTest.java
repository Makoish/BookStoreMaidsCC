//package UnitTests;
//
//import com.maids.cc.bookStore.repository.PatronRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//@RunWith(SpringRunner.class)
//public class PatronRepositoryTests {
//
//    @Autowired
//    private PatronRepository patronRepository;
//
//    @Test
//    public void testSavePatron() {
//        Patron patron = new Patron("John", "Doe", "01019937553", "johndoe@example.com"),;
//        Patron savedPatron = patronRepository.save(patron);
//
//        assertNotNull(savedPatron.getId());
//        assertEquals("John Doe", savedPatron.getName());
//    }
//
//    @Test
//    public void testFindPatronById() {
//        Patron patron = new Patron("John", "Doe", "01019937553", "johndoe@example.com");
//        Patron savedPatron = patronRepository.save(patron);
//
//        Optional<Patron> foundPatron = patronRepository.findById(savedPatron.getId());
//        assertTrue(foundPatron.isPresent());
//        assertEquals("Jane Smith", foundPatron.get().getName());
//    }
//
//    @Test
//    public void testDeletePatron() {
//        Patron patron = new Patron("John", "Doe", "01019937553", "johndoe@example.com");
//        Patron savedPatron = patronRepository.save(patron);
//
//        patronRepository.deleteById(savedPatron.getId());
//        Optional<Patron> deletedPatron = patronRepository.findById(savedPatron.getId());
//        assertFalse(deletedPatron.isPresent());
//    }
//}
