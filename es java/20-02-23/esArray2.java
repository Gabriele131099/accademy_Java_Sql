import java.util.*; // import the Scanner class
public class esArray2 {
    public static void main(String[] args) {
        int count = 0;
        Scanner anagrafica = new Scanner(System.in);
        Scanner counter = new Scanner(System.in);
        //array olaceholder
        String[] arrayString = {"nome","cognome","email","età"};
        //simil matrice
        String[][] array1 = {{"","","",""},{"","","",""},{"","","",""}};
        //array presa dati
        String[] arrayStringTmp = {"","","",""};
        int choiseMenuCount = 0;
        do {
            System.out.println("1 aggiungi anagrafica, 2 modifica anagrafica");
             choiseMenuCount = counter.nextInt();
            switch (choiseMenuCount) {
                case 1:
                //controllo per non andare in overflow
              
                    //chiedo i dati 
                    for (int i = 0; i < arrayString.length; i++) {
                        System.err.println("Inserire " + arrayString[i]);  
                        //salvo i dati
                        arrayStringTmp[i]= anagrafica.nextLine();
                    }
                    //carico l'utente nella matrice 
                    array1.add(arrayStringTmp) ;
                 
                    
                    System.out.println(count);
                    //stampo l'utente appena caricato
                    for (String string : arrayStringTmp) {
                        System.out.printf(string +" ");
                    }
               
               
                    break;
                case 2:
                //stampo tutti gli user
                for (String[] string : array1) {
                    System.out.println("utente");
                    for (int index = 0; index < string.length; index++) {
                        System.out.printf( string[index]+" ");
                    }
                }
                //prendo il nome
                System.out.println("Modifica l'utente presente cercandolo per il nome");
                String nomeTmp = anagrafica.nextLine();
                
                //scorro la matrice
                for (String[] string : array1) {
                    //cerco l'utente
                    if (string[0].toLowerCase().equals(nomeTmp.toLowerCase())) {
                        System.out.println("utente ");
                        //stampo i dati dell utente trovato
                        for (int index = 0; index < string.length; index++) {
                            System.out.println( string[index]+" ");
                        }
                        
                           //aggiorno i dati
                           for (int i = 0; i < arrayString.length; i++) {
                            System.err.println("Inserire " + arrayString[i]);  
                            arrayStringTmp[i]= anagrafica.nextLine();
                            }
                            //mostro i dati
                            for (int index = 0; index < string.length; index++) {
                                System.out.println( string[index]+" ");
                           }
                        }
                    }
                    System.out.println("I nostri utenti");
                    
                    for (String[] string : array1) {
                        System.out.println("utente");
                        for (int index = 0; index < string.length; index++) {
                            System.out.printf( string[index]+" ");
                        }
                    }
                    break;
                default:
                    break;
            }
        } while (choiseMenuCount == 1);

       
        anagrafica.close();
    }
}
