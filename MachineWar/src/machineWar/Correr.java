
package machineWar;

class Correr {
    /**
     * Metodo unico de la clase correr que se encarga de llamar a la clase Menus
     */
    public void correr(){
        Menus menus = new Menus();
        menus.show(true); 
        menus.setMenus(menus);
    }
}
