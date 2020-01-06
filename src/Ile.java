
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Ile extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;
        public int nb;
	
     public  int TAILLE=MenuControl.nbrcase;
     public   int nbrCorsaire=MenuControl.nbrcorsaire;
        private Corsaire corsaire;
        private Case caseActive;
        private Case piratecase; 
        private Case flibcase; 
       	public boolean partiegagne = true;
       	private boolean trn=true; 
       	private EtatCorsaire state;
         private int nbmachette=0;
         private int nbmousquet=0;
         private int nbarmure=0;
         private int flib=0;
         private int triso=0;
         private int pelle=0;
         private int mosqu=0;
         private int arm=0;
         private int mach=0;
         private int eau=0;
         private int foret=0;
              

	
        // creation du l'île 
	public Ile(int taille){
		trn=!false;
		setLayout(new GridLayout(TAILLE, TAILLE));
		for(int i=0; i<TAILLE; i++){
			for(int j=0; j<TAILLE; j++){
					ajouterCase(Constantes.NOIR);	
			}
		}
		
		//for(int j=0;j<5;j++) {
	//		ajouterCase(Couleur.ORANGE);
		//}
               ;
		init();
                
	}
        
	private void ajouterCase(Constantes couleur){
		Case case1 = new Case(couleur);
		case1.addMouseListener(new CaseDeplacement(case1, this));
		add(case1);
	}

	private Corsaire creerCorsaire(Constantes couleur){
	        corsaire = new Corsaire(couleur);
		corsaire.addMouseListener(new CorsaireEvenement(corsaire, this));
		return corsaire;
	}
        	private Boucanier creerPirate(Constantes couleur){
		Boucanier boucanier = new Boucanier(couleur);
		return boucanier;
	}
                private Pirate creerPirate(Constantes couleur,String s){
		Pirate boucanier = new Pirate(couleur,s);
		return boucanier;
	}
                private Flibustier creerFlibustier(Constantes couleur){
		Flibustier flibustier = new Flibustier(couleur);
		return flibustier;
                }
	

	private void init(){
                        
                       
                        
			
				for(int i=0;i<nbrCorsaire;i++) {
					Random random = new Random();
					int nbAleatoire;
					nbAleatoire =(1+ random.nextInt(6));
					
					getCase(72+nbAleatoire).add(creerCorsaire(Constantes.NOIR));
					
						}
				
			     // le pourcentage des cases   étendu Eau et foret :       
							double variable=((TAILLE*TAILLE)*5)/100;
							int pourcentage = (int) Math.round(variable);
							for(int k=0; k<pourcentage;k++) {
			                	Random random = new Random();
								int nbAleatoire;
								nbAleatoire =(1+ random.nextInt(7));
								 eau= (int) (Math.random() * TAILLE*TAILLE);
								 foret= (int) (Math.random() * TAILLE*TAILLE);
		                        getCase(eau+nbAleatoire).setEau(true);
		                        getCase(eau+nbAleatoire).add(creerPirate(Constantes.VERT,"eau.png"));
		                        
		                        getCase(foret+nbAleatoire+1).setForet(true);
		                        getCase(foret+nbAleatoire+1).add(creerPirate(Constantes.VERT,"foret.png"));
		                        
							}
							
							
							
				
                 // fin de la méthode
							 boolean l=true;
                         while(l)
                        {
                            pelle= (int) (Math.random() * TAILLE*TAILLE);
                            this.nb = (int) (Math.random() * TAILLE*TAILLE);
                            this.flib = (int) (Math.random() * TAILLE*TAILLE);
                            triso = (int) (Math.random() * TAILLE*TAILLE);
                            arm=(int) (Math.random() * TAILLE*TAILLE);
                            mosqu= (int) (Math.random() * TAILLE*TAILLE);
                            mach= (int) (Math.random() * TAILLE*TAILLE);
                            if(nb!=72  && pelle!=72 && triso !=72 && arm!=72 && mosqu!=72 && this.flib!=72 && mach!=72)
                            {
                            l=false;
                            }        
                        }
                         
                        
                        getCase(nb).add(creerPirate(Constantes.VERT));
                        getCase(nb).getComponent(0).setVisible(true);
                        getCase(flib).add(creerFlibustier(Constantes.VERT));
                        piratecase = getCase(nb);
                        flibcase = getCase(flib);
                        getCase(triso).setTrisor(true);
                        getCase(triso).add(creerPirate(Constantes.VERT,"tresore.png"));
                        
                        
                        for(int i=0;i<this.nbrCorsaire;i++) {
                        	Random random = new Random();
        					int nbAleatoire;
        					nbAleatoire =(1+ random.nextInt(7));
                        // meme nombre de corsaire que pelle
                        getCase(pelle+nbAleatoire).setPelle(true);
                        getCase(pelle+nbAleatoire).add(creerPirate(Constantes.VERT,"pelle.png"));
                        }
                        // nombre de machet mousquet armure plus que corsaire
                        for(int i=0;i<this.nbrCorsaire+1;i++) {
                        	Random random = new Random();
        					int nbAleatoire;
        					nbAleatoire =(1+ random.nextInt(7));
                        getCase(arm+nbAleatoire).setArmure(true);
                        getCase(arm+nbAleatoire).add(creerPirate(Constantes.VERT,"armure.png"));
                        getCase(mosqu+nbAleatoire).setMousquet(true);
                         getCase(mosqu+nbAleatoire).add(creerPirate(Constantes.VERT,"arme.png"));

                        getCase(mach+nbAleatoire).setMachette(true);
                        getCase(mach+nbAleatoire).add(creerPirate(Constantes.VERT,"machette.png"));
                        }
                        
                         state = new EtatCorsaire();
                         state.setPointsdevie(String.valueOf(corsaire.getVie()));
                        // state.setVisible(true);
                         state.setAyantpelle("NON");
                         state.setArmure("0");
                         state.setMosquet("0");
                         state.setNom("PLAYER");
	
                        
	}

	public Case getCase(int i, int j){
		return (Case) getComponent(j+i*TAILLE);
	}

	public Case getCase(int i){
		return (Case) getComponent(i);
	}

	public void afficherPossibilites(Corsaire p){
		if((p.getCouleur().equals(Constantes.NOIR) && trn)){
			int i=0;
			int j=0;
			for(int k=0; k<TAILLE*TAILLE; k++){
				getCase(k).setSelectionnee(false);
				if(getCase(k).getComponentCount()!=0 && getCase(k).getComponent(0).equals(p)){
					caseActive=getCase(k);
					i=k/TAILLE;
					j=k%TAILLE;

				}
                                
                                
			}
			selectionnerCases(i, j, p.getCouleur());
		}
	}

	public void selectionnerCases(int i, int j, Constantes couleur){
                
		               
			if(i-1>=0 && j-1>=0 ){
				getCase(i-1, j-1).setSelectionnee(true);
			}
                        if(i+1<TAILLE && j+1<TAILLE ){
                                getCase(i+1, j+1).setSelectionnee(true);
                        }
                        if(i+1<TAILLE && j-1>=0 ){
                                getCase(i+1, j-1).setSelectionnee(true);
                        }
                        if(i-1>=0 && j+1<TAILLE ){
                                getCase(i-1, j+1).setSelectionnee(true);
                        }
                        if(i-1>=0 ){
                                getCase(i-1, j).setSelectionnee(true);
                        }
                        if(i+1<TAILLE ){
                                getCase(i+1, j).setSelectionnee(true);
                        }
                        if(j+1<TAILLE ){
                                getCase(i,j+1).setSelectionnee(true);
                        }
                        if(j-1>=0 ){
                                getCase(i, j-1).setSelectionnee(true);
                        }
                
              
            
            
        }

	
	
	public void deplacer(Case case1){
                int a;
                int b;
 
                        if(getCase(triso).getComponentCount() == 0)
                        {
                            getCase(triso).add(creerPirate(Constantes.VERT,"tresore.png"));
                            getCase(triso).getComponent(0).setVisible(true);
                            getCase(triso).repaint();
                           // state= new States();
                            //state.setVisible(true);
                           
                        }
                       
                        if(case1 == getCase(triso))
                        {
                            getCase(triso).removeAll();
                       
                           case1.add(caseActive.getComponent(0));
                              for(int k=0; k<TAILLE*TAILLE; k++){
                                getCase(k).setSelectionnee(false);
                                   }
                            
                             caseActive.removeAll();
                             caseActive.repaint();
                            caseActive=null;
                            case1.repaint();
                           
                           }
                        else
                        {
                        case1.add(caseActive.getComponent(0));
                              for(int k=0; k<TAILLE*TAILLE; k++){
                                getCase(k).setSelectionnee(false);
                                   }
                            
                             caseActive.removeAll();
                             caseActive.repaint();
                            caseActive=null;
                            case1.repaint();
                        
                        }
                       
                       
                       
                if(piratecase.getComponentCount()!=0)
                {
                if(case1 !=piratecase && case1 != flibcase){
                b = Flibustier.seDeplacer(getLigne(flibcase),getColonne(flibcase));
                a=Boucanier.seDeplacer(getLigne(piratecase),getColonne(piratecase));
                if( piratecase != null && flibcase != null)
                {
             while(a==b || this.pelle==a || b==this.pelle|| a==this.triso || b==this.triso ||
            		 a == this.mosqu || b==this.mosqu || a== this.arm || b==this.arm
            		 ||a== this.eau || b==this.eau || a== this.foret || b==this.foret)
                {
                   b = Flibustier.seDeplacer(getLigne(flibcase),getColonne(flibcase));
                   a=Boucanier.seDeplacer(getLigne(piratecase),getColonne(piratecase));   
                }}
                 if(piratecase != null)
                 {
                getCase(a).add(piratecase.getComponent(0));
                piratecase.removeAll();
                piratecase.repaint();
                piratecase=getCase(a);
                getCase(a).repaint();
                 }
                 if(flibcase != null)
                 {
                getCase(b).add(flibcase.getComponent(0));
                flibcase.removeAll();
                flibcase.repaint();
                flibcase=getCase(b);
                getCase(b).repaint();
                 }
                }
                
                else
                {
                      
                    if(corsaire.isAyantMosquet() ==0 && corsaire.getAyantArmure() ==0 && corsaire.getVie()<=40)
                    {
                    case1.remove(1);
                    case1.repaint();
                    GagnePartie fin = new GagnePartie("VOUS AVEZ PERDU pourcetage de vie"," Insufisante");
                    fin.setVisible((true));
                    partiegagne = false;
              
                    }
                    else
                    {
                        case1.remove(0);
                        case1.repaint();
                        //corsaire.getVie()+=10;
                    }
           
                }
                
                
                }
                if(case1.isPelle())
                {
                    corsaire.setAyantPelle(true);
                  
                    case1.remove(0);
                        
                }
                 if(case1.isPelle())
                {
                    case1.setPelle(false);
                    corsaire.setAyantPelle(true);
                     
                }
               if(case1.isMousquet())
                {
                    case1.setMousquet(false);
                    corsaire.setAyantMosquet();
                    
                   
                    corsaire.setVie(90);
                    //state.setMosquet(String.valueOf(nbm));
                     case1.remove(0);
                }
               
               if(case1.isMachette())
               {
                   case1.setMachette(false);
                   corsaire.setAyantMachette();
                   
                   nbmachette+=1;
                   corsaire.setVie(40);
                   //state.setMosquet(String.valueOf(nbm));
                    case1.remove(0);
               }

               
               
               if(case1.isForet())
               {	 if(nbmachette>=1) {
                   			case1.setForet(false);
                   			case1.remove(0);}
		               else {
		            	 JOptionPane.showMessageDialog(null,"Impossible d'avancer pas de machette \n  Choisir autre case ");
		                    //corsaire.getComponent(n)
		            	 	//case1.remove(-1);
		                    //case1.repaint();
		               	}
               }
               
               if(case1.isArmure())
                {
                    case1.setArmure(false);
                    corsaire.setVie(10);
                   nbarmure++;
                  
                     state.setArmure(String.valueOf(nbarmure));
                      case1.remove(0);
                         
                }
               
               if(piratecase == case1)
               {
                   if(corsaire.isAyantMosquet() ==0 && corsaire.getAyantArmure() ==0 )//dadgh
                    {
                    case1.remove(1);
                    case1.repaint();
                    
                    }
                    else
                    {
                        case1.remove(0);
                        case1.repaint();
                        GagnePartie fin = new GagnePartie("VOUS AVEZ PERDU","Vie insufaisant");
                    fin.setVisible((true));
                    this.setVisible(false);
                   partiegagne = false;
                 
                    }
               }
               
               if(case1.isEau())
               {
            	   
            	   JMenuBar menuBar = new JMenuBar();

            	 //Build the first menu.
            	 JMenu menu = new JMenu("A Menu");
            	 menu.setMnemonic(KeyEvent.VK_A);
            	 menu.getAccessibleContext().setAccessibleDescription(
            	         "The only menu in this program that has menu items");
            	 menuBar.add(menu);
            	 JOptionPane.showMessageDialog(null, "Etendu eau Impossible d'y acceder");
            	 
                  /* case1.remove(0);
                   case1.repaint();
                   FinPartie fin = new FinPartie("VOUS AVEZ PERDU ","");
                   fin.setVisible((true));
                   this.setVisible(false);
                   partiegagne = false;*/
               }
               
               
               
               if(flibcase == case1)
               {
                   if(corsaire.isAyantMosquet() ==0 && corsaire.getAyantArmure() ==0 )
                    {
                    case1.remove(1);
                    case1.repaint();
                
                    }
                    else
                    {
                        case1.remove(0);
                        case1.repaint();
                     GagnePartie fin = new GagnePartie("VOUS AVEZ PERDU","Pas d'Arme");
                    fin.setVisible((true));
                    this.setVisible(false);
                    partiegagne = false;
                    }
               }
                 if(corsaire.getAyantPelle())
               {
                   if(case1.isTrisor())
                   {
                    GagnePartie fin = new GagnePartie("VOUS AVEZ GAGNNER","Vous avez dettere Tresore");
                         
                    	fin.setVisible((true));
                         this.setVisible(false);
                         partiegagne = false;
                         
                   }
                   
               }
               
               /* Creuuuser 
                 if(corsaire.getAyantPelle())
                 {
                	 
                     getCase(corsaire).add(creerPirate(Couleur.VERT,"tresore.png"));
                     getCase(triso).getComponent(0).setVisible(true);
                     getCase(triso).repaint();
                    // state= new States();
                     //state.setVisible(true);
                    
                 }*/
                
                 
                

                
        
        }
	private int getLigne(Case case1){
		int res=0;
		for(int i=0; i<TAILLE*TAILLE; i++){
			if(getCase(i).equals(case1)){
				res=i/TAILLE;
			}
		}
		return res;
	}

	private int getColonne(Case case1){
		int res=0;
		for(int i=0; i<TAILLE*TAILLE; i++){
			if(getCase(i).equals(case1)){
				res=i%TAILLE;
			}
		}
		return res;
	}
	
      
	


}