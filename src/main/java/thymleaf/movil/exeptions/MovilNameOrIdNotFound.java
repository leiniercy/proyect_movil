package thymleaf.movil.exeptions;

public class MovilNameOrIdNotFound extends Exception{
    
    public MovilNameOrIdNotFound(String sms){
        super(sms);
    }
    public MovilNameOrIdNotFound(){
        super("Movil no encontrado");
    }

}
