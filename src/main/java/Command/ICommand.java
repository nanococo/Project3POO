/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author Fernando Alvarez
 */
public interface ICommand {
    
    public void execute(String[] args);
    public String getCommandName();
    
}
