// L’objectif du TP3 est de fournir un arbre de recouvrement à coût minimum 
// (ARMin) du graphe des sites d’un quartier en se basant sur l’algorithme 
// de Prim-Jarnik.

// Les arêtes de mêmes poids doivent être traitées selon l’ordre alphanumérique 
// des nœuds de départs et dans le cas d’égalité des poids et des nœuds de 
// départs, utiliserez l’ordre alphanumérique des nœuds d’arrivés.

public class Tp3 {
    public static void main(String[] args) {
        Process process = new Process(args);
        process.compute();
        
    }
}