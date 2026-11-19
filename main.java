import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class main{
    public static void main(String[] args){
        Object resultat=0;
        boolean com=true;
        int changement=0;
        List<String> operation=new ArrayList<>();
        List<Object> nombre=new ArrayList<>();
        byte stade;
        Scanner clavier=new Scanner(System.in);
        System.out.println("Bonjour dans Ma calculatrice");
        for (int i=0;i<2;i++){
            if (i!=0) {
                System.out.println("====Menu====");
                System.out.println("1.la somme");
                System.out.println("2.la multiplication");
                System.out.println("3.la division");
                System.out.println("4.la soustraction");
                System.out.println("5.modulo");
                System.out.println("6.revenir une étape en arriere");
                System.out.println("default:la somme");
                System.out.println("entre le nombre pour choisir l'operation à faire");
                int op=clavier.nextInt();
                resultat=switch(op){
                    case 1-> {System.out.println("l'operation choisit est la somme");
                        operation.add("+");
                        System.out.println("""
                                        ===Type de variable
                                        1.byte
                                        2.short
                                        3.int
                                        4.long
                                        5.float
                                        6.double
                                        7.caractere
                                        default.int""");
                        System.out.println("entre le numero du type correspondant");
                        int type=clavier.nextInt();
                        switch(type){
                            case 1->{
                                System.out.println("entre ton nombre de type byte");
                                System.out.println(Byte.MIN_VALUE+" <= nombre choisit <= "+Byte.MAX_VALUE);
                                byte chif=clavier.nextByte();
                                if (resultat instanceof Integer) {
                                    long somme = (long) (Integer) resultat + chif;
                                    if (somme < Integer.MIN_VALUE || somme> Integer.MAX_VALUE) {
                                        System.out.println("depassement d'une borne limite du type int");
                                        System.out.println("chanegement de type : int => Long");
                                        yield resultat=((Number)resultat).longValue() +chif;
                                        }
                                    }
                                }
                                else if (resultat.getClass() == Long.class) {
                                    if (chif + resultat < Long.MIN_VALUE || chif + resultat > Long.MAX_VALUE) {
                                        System.out.println("depassement d'une borne limite du type Long");
                                        System.out.println("on va te proposer le changement de type le plus aproprier");
                                         if (-Float.MAX_VALUE <= chif + resultat && chif + resultat <= Float.MAX_VALUE) {
                                            System.out.println("Float peux etre choisit comme type,avant de choisir de continuer on vas voir la difference de precision");
                                            float convf=(float) chif+resultat;
                                            System.out.println("la difference quand on a adopter une conversion vers float "+convf - chif-resultat);
                                            double convd=(double) chif+resultat;
                                            System.out.println("la difference quand on a adopter une conversion vers double "+convd - chif-resultat);
                                            System.out.println("pour choisir la conversion vers float choisir 0 sinon choisir 1 pour double");
                                            changement = clavier.nextInt();
                                            if (changement == 0) {
                                                resultat=(float) resultat;
                                                System.out.println("chanegement de type : int => Float");
                                            }
                                            if (changement==1){
                                                resultat=(double) resultat;
                                            }
                                        } else {
                                            System.out.println("la conersion en double est la seule possible");
                                            resultat=(double) resultat;
                                            System.out.println("chanegement de type : int => Double");
                                        }
                                    }
                                }
                                else if (resultat.getClass() == Float.class) {
                                    if (chif + resultat < -Float.MAX_VALUE || chif + resultat > Float.MAX_VALUE) {
                                        System.out.println("depassement d'une borne limite du type Float");
                                        System.out.println("la conersion en double est la seule possible");
                                        resultat=(double) resultat;
                                        System.out.println("chanegement de type : int => Double");
                                    }
                                }
                                nombre.add(chif);
                                yield resultat+=(resultat.getClass())chif;}
                            case 2->{
                                System.out.println("entre ton nombre de type short");
                                if (com) System.out.println("on a une promotion numérique\n"+
                                        "short -> int")
                                short chif=clavier.nextShort();
                                nombre.add(chif);
                                yield resultat+=chif;}
                            case 3->{
                                System.out.println("entre ton nombre de type int");
                                if (com) System.out.println("on n'a pas de promotion numérique")
                                int chif=clavier.nextInt();
                                nombre.add(chif);
                                yield resultat+=chif;}
                            case 4->{
                                System.out.println("entre ton nombre de type long");
                                if (com) System.out.println("on n'a pas une promotion numérique")
                                long chif=clavier.nextLong();
                                nombre.add(chif);
                                yield resultat+=chif;}
                            case 5->{
                                System.out.println("entre ton nombre de type float");
                                if (com) System.out.println("on n'a pas une promotion numérique")
                                float chif=clavier.nextFloat();
                                nombre.add(chif);
                                yield resultat+=chif;}
                            case 6->{
                                System.out.println("entre ton nombre de type double");
                                if (com) System.out.println("on n'a pas une promotion numérique")
                                double chif=clavier.nextDouble();
                                nombre.add(chif);
                                yield resultat+=chif;}
                            case 7->{
                                System.out.println("entre ton nombre de type caractere");
                                if (com) System.out.println("on a une promotion numérique\n"+
                                        "char -> int")
                                char chif=clavier.next();
                                nombre.add(chif);
                                yield resultat+=chif;}
                            default->{
                                System.out.println("entre ton nombre de type int");
                                if (com) System.out.println("on n'a pas de promotion numérique")
                                int chif=clavier.nextInt();
                                nombre.add(chif);
                                yield resultat+=chif;}
                        }

                    }
                    case 2-> {System.out.println("l'operation choisit est la multiplication");
                        System.out.println("entre ton nombre");
                        double chif=clavier.nextDouble();
                        yield resultat*=chif;
                    }
                    case 3-> {System.out.println("l'operation choisit est la division");
                        System.out.println("entre ton nombre");
                        double chif=clavier.nextDouble();
                        yield resultat/=chif;
                    }
                    case 4-> {System.out.println("l'operation choisit est la soustraction");
                        System.out.println("entre ton nombre");
                        double chif=clavier.nextDouble();
                        yield resultat-=chif;
                    }
                    case 5-> {System.out.println("l'operation choisit est le modulo");
                        System.out.println("entre ton nombre");
                        double chif=clavier.nextDouble();
                        yield resultat%=chif;
                    }
                    case 6 ->{
                        System.out.println("On va revenir une étape en arriére");
                        resultat=stade.getLast();
                        stade.removeLast();
                        nombre.removeLast();
                        System.out.println("C'est Fait");
                    }
                    default-> {System.out.println("l'operation choisit est la somme");
                        System.out.println("entre ton nombre");
                        double chif=clavier.nextDouble();
                        yield resultat+=chif;
                    }
                };

                System.out.println("le resultat de cette operation est :"+resultat);
                stade=(resultat.getClass()) resultat;
            }
            if (i==0) {
                System.out.println("entre ton nombre");
                double chif = clavier.nextDouble();
            }
            for (int i=0,j=0;j<=operation.size() && i<=nombre.size();i++){
                if (i%2==0) {
                    System.out.print(nombre.get(i)+" "+operation.get(i));
                    j++;
                }
                else System.out.print(nombre.get(i));
            }
            if (i==1) {
                System.out.println("pour finir entre 0,sinon entre un autre nombre");
                double test = clavier.nextDouble();
                if (test!=0)
                    i--;
            }
            if (com){
                System.out.println("pour enlever les commentaire entrer 0");
                double test = clavier.nextDouble();
                if (test==0){
                    com=false;
                }
            }
            else {
                System.out.println("pour restituer les commentaire entrer 0");
                double test = clavier.nextDouble();
                if (test==0){
                    com=true;
                }
            }
        }
    }
}
