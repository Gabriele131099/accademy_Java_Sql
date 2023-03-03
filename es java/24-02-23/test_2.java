import java.util.ArrayList;

public class test_2 {
    public static void main(String[] args) {
        // 1- Cos'è OOP e come la definiamo a diversi livelli. 
        // 2- Definisci Java e i suoi elementi fondamentali 
        // 3- Descrivi, spiega i e prova i loop e le condizioni che abbiamo visto 
        // 4- Cosa sono i metodi cosa sono i loro parametri e quando diventano attributi, e cos'è overloading? provali e spiegali 
        // 5- Cos'è l'incapsulamento funzionale e quando lo usiamo implicitamente? 
        // 6- Cos'è il casting e di quali tipi ne abbiamo traccia in java e nell'OOP, provalo e spiegalo 
        // 7- Cos'è la tipizzazione forte e debole, quali sono i tipi basilari e non e quali sono i modi in cui interagisce con i metodi?

        // 1- Cos'è OOP e come la definiamo a diversi livelli. 
        //Il paradigma OOP è basato sugli oggetti e specifiche strutture di dati all’interno di una classe, 
        // che interagiscono tra di loro, attraverso messaggi o metodi. 
        // I vantaggi più significativi della OOP sono principalmente cinque: 
        // astrazione, incapsulamento, ereditarietà, polimorfismo e riuso del codice.
        //Astrazione: 'mostra' solo gli attributi rilevanti degli oggetti e
        // 'nasconde' i dettagli non necessari. 
        //Incapsulamento: la possibilità di un linguaggio di programmazione ad oggetti di accorpare 
        // metodi e proprietà all’interno di un unica area
        //Ereditarietà: è la possibilità di far “ereditare” tutti i metodi e le proprietà di una classe ad un’altra
        //Polimorfismo: è l’abilità, per esempio da parte di una variabile, di poter essere vista come di tipologie diverse.
        // Ad esempio un Numero può essere visto allo stesso tempo come int, come float, come double
        // Riuso del codice: tramite l'uso di metodi è possibili richiamare, molteplici volte,
        // frammenti di codice

         // 2- Definisci Java e i suoi elementi fondamentali 
        // Java è un linguaggio di programmazione orientato agli oggetti, i suoi elementi fondamentali sono 
        // metodi, classi e una forte tipizzazione

       // 3- Descrivi, spiega i e prova i loop e le condizioni che abbiamo visto 
        //do while: permette un primo ciclo senza la visione della condizione, dal secondo si controllerà quest'ultima    
        int a = 5;
        int b = 4;
        do {
            System.out.println(a);
            a++;
        } while (a<b);
        //while: entra nel ciclo solo se si soddisfa la condizione
        while (a>b) {
            System.out.println("entrerà solo se a>b");
            a--;
        }
        //for: gestisce il numero di cicli tramite un contattore ( index), che viene incrementato ad ogni ciclo
       for (int index = 0; index < 5; index++) {
        System.out.println("sono il for " + index);
       }
        //forEach: non richiede la dichiarazione di un contattore, si ferma in modo autonomo allo finire 
        // della lunghezza dell array
        int[] arrayTest = {1,2,3,4,5};
       for (int n : arrayTest) {
        System.out.println(n);
       }
    
      // 4- Cosa sono i metodi cosa sono i loro parametri e quando diventano attributi, e cos'è overloading? provali e spiegali 
      // Un metodo è una porzione di codice a cui si associa un nome, per poterlo utilizzarlo in varie aree
    // i parametri sono quei valori che uso per trattare i dati ricevuti dall'esterno del metodo , gli attributi
    // vengono passati al metodo in fase di chiamata. L'overloading è la possibilità di dichiarare più metodi 
    // con lo stesso nome, dove in base al numero di parametri che si danno può avere azioni differenti
    // i metodi non statici sono associati ad ogni singola istanza di una classe e perciò il loro contesto 
    // di esecuzione (quindi l'insieme delle variabili cui possono accedere) è relativo all'istanza stessa:
    //  possono accedere e modificare le variabili dell'istanza e modificarne lo stato
    // all'opposto i metodi statici non sono associati ad una istanza ma solo ad una classe. 
    // Quindi non potranno interagire con le variabili di istanza, ma solamente con quelle statiche.
    

    // 5- Cos'è l'incapsulamento funzionale e quando lo usiamo implicitamente? 
    // L'incampusulamento funzionale ha lo scopo di rendere ancora più semplice il codice dell'interfaccia 
    // di implementazione, per esempio creando un unica interfaccia pubblica per l'inizializzazione dei dati
    // // Usando il modificatore private applicato ad un metodo, si ottiene un incapsulamento funzionale

    //6- Cos'è il casting e di quali tipi ne abbiamo traccia in java e nell'OOP, provalo e spiegalo 
    // Il casting permette la conversione di variabili di un tipo ad un tipo superiore, 
    // tipo string con char, int e double
    double c =  a;
    String s = "String";
    char r = s.charAt(1);

     // 7- Cos'è la tipizzazione forte e debole, quali sono i tipi basilari e non e quali sono i modi in cui interagisce con i metodi?
    //  Nei linguaggi a tipizzazione forte, i valori assegnati alle variabili hanno dei tipi 
    //  ben definiti, mentre in contesti di tipizzazione debole, le variabili possono riferirsi a 
    //  valori di qualsiasi tipo o mutarne i tipi
    //  i tipi basilari sono, int double float bite long short char boolean
    // 
    // String al suo interno ha dei metodi per la gestione delle stringhe

    //8- Differenza fra array e arrayList
    int[] arrayTmp = {1,2,3,4,5,6};
     ArrayList<Integer> myArryList = new ArrayList<Integer>();

    //gli array hanno una dimensione statica e fare opezioni su di essi è poco ortodosso
    // gli array list hanno dei metodi che ne permettono una manipolazione agevole, come add() remove() 
    // indexOf() size() ecc..., non hanno una dimensione statica
    }
    public void myMethodNonStatic(){
        // non ritorna nulla void
        // utilizzabile con un richiamo nomeProg name = new nomeProg();
        // name.nomeMetodo();
    }
    static void myMethodStatic(){
        // non ritorna nulla void
        // utilizzabile con un semplice richiamo myMethodStatic()
    }
    static int myMethodStaticReturn(){
        // ritorna un iintero
        // utilizzabile con un semplice richiamo myMethodStaticReturn()
        return 2;
    }

}
