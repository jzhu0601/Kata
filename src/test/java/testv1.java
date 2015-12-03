///**
// * Created by jzhu on 12/2/2015.
// */
//
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class PacmanKataTest {
//
//    PacmanKata pacmanKata = new PacmanKata(10, 10);
//
//    @Test
//    public void testBoradCreationSuccess() {
//        assertTrue(pacmanKata.boardCreated());
//    }
//
//    @Test
//    public void testPacmanCreationSuccess(){
//        assertTrue(pacmanKata.pacmanCreated());
//    }
//
//    @Test
//    public void testPacmanMoveUp(){
//        //Pacman moved up 3 steps, starting height on the board is 5, 5-3 is 2.
//        assertEquals(2,pacmanKata.tickUp(3));
//    }
//
//    @Test
//    public void testPacmanMoveRight(){
//        //Pacman moved right 3 steps, starting width on the board is 5, 5+3 is 8.
//        assertEquals(8,pacmanKata.tickRight(3));
//    }
//
//    @Test
//    public void testPacmanMoveDown(){
//        //Pacman moved down 3 steps, starting width on the board is 5, 5+3 is 8.
//        assertEquals(8,pacmanKata.tickDown(3));
//    }
//
//    @Test
//    public void testPacmanMoveLeft(){
//        //Pacman moved left 3 steps, starting width on the board is 5, 5-3 is 2.
//        assertEquals(2,pacmanKata.tickLeft(3));
//    }
//
//
//}
