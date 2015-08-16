/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence;

/**
 *
 * @author zua
 */
interface Alive {

    public void start();

    public void finish();

    public void pause();

    public void resume();

}
