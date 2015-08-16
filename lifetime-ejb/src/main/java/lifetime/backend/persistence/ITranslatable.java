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
public interface ITranslatable {
    public ITranslatable translateTo(String language);
}
