/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractMessagingSystem;

import CientApp.Client;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Alvarez
 */
public class TestMessage extends BaseMessage{
    
    private static final String NAME = "TEST";
    
    String name;
    int value1;
    boolean value2;
    String value3;
    String value4;
    

    @Override
    public void packContent(String[] content) {//Tokenizer? Alguna manera de recorrer los atributos de la clase? Hay que tomar en cuenta el name, Para objetos completos leer bytes?
        /*Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            value1 = parse(field.getGenericType(),content[field.pos],T variable);
        }*/
        value1 = Integer.parseInt(content[0]);
        value2 = Boolean.parseBoolean(content[1]);
        value3 = content[2];
        value4 = content[3];
    }

    @Override
    public String[] unpackContent() {//Intentar hacer el inverso
        /*Field[] fields = this.getClass().getDeclaredFields();
        String content[] = new String[fields.length];
        for (int i = 0; i < content.length; i++) {
            try {
                content[i] = String.valueOf(fields[i].get(this));
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(TestMessage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(TestMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return content;*/
        String content[] = new String[4];
        content[0] = String.valueOf(value1);
        content[1] = String.valueOf(value2);
        content[2] = String.valueOf(value3);
        content[3] = String.valueOf(value4);
        return content;
    }

    public static String getNAME() {
        return NAME;
    }

    @Override
    public String getId() {
        return name;
    }


    
}
