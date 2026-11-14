import java.util.Scanner;
import java.util.List;
public class main{
    public static void main(String[] args){
        double resultat=0;
        boolean com=true;
        List<String> operation;
        List<Object> nombre;
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
                System.out.println("default:la somme");
                System.out.println("entre le nombre pour choisir l'operation à faire");
                int op=clavier.nextInt();
                resultat=switch(op){
                    case 1-> {System.out.println("l'operation choisit est la somme");
                        operation.add("+")
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
                        int type=clavier.nextInt("entre le numero du type correspondant");
                        switch(type){
                            case 1->{
                                System.out.println("entre ton nombre de type byte");
                                byte chif=clavier.nextByte();
                                if (com) {
                                    System.out.println("on a une promotion numérique\n"+
                                            "byte -> int");
                                    if (type(chif)!=type(resultat)) System.out.println("convertions d'ajustement : int => "+type(resultat));
                                }
                                if (chif+resultat<INTEGER.MIN_VALUE || chif+resultat>INTEGER.MAX_VALUE) {
                                    System.out.println("depassement d'une borne limite de valeur du type int");
                                    (double) resultat;
                                    System.out.println("chanegement de type : int => Double");
                                }
                                nombre.add(chif);
                                yield resultat+=chif;}
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
                                if (com) System.out.println("on n'a pas une promotion numérique"
                                long chif=clavier.nextLong();
                                nombre.add(chif);
                                yield resultat+=chif;}
                            case 5->{
                                System.out.println("entre ton nombre de type float");
                                if (com) System.out.println("on n'a pas une promotion numérique"
                                float chif=clavier.nextFloat();
                                nombre.add(chif);
                                yield resultat+=chif;}
                            case 6->{
                                System.out.println("entre ton nombre de type double");
                                if (com) System.out.println("on n'a pas une promotion numérique"
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
                    default-> {System.out.println("l'operation choisit est la somme");
                        System.out.println("entre ton nombre");
                        double chif=clavier.nextDouble();
                        yield resultat+=chif;
                    }
                };

                System.out.println("le resultat de cette operation est :"+resultat);

            }
            if (i==0) {
                System.out.println("entre ton nombre");
                double chif = clavier.nextDouble();
            }
            for (int i=0,j=0;j<=operation.length && i<=nombre.length;i++){
                if (i%2==0) {
                    System.out.print(nombre[i]+" "+operation[j]);
                    j++
                }
                else System.out.print(nombre[i]);
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
