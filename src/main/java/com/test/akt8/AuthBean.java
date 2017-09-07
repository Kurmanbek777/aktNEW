/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.akt8;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

/**
 *
 * @author kbakytbekov
 */
@Named(value = "authBean")
@SessionScoped
public class AuthBean extends BaseBean {

    private String username;
    private String password;
    private boolean admin = false;
    private boolean manager = false;

    //Log IN
    @Override
    public void search() {//this is auth method
        FacesContext context = FacesContext.getCurrentInstance();
        if (username == null && password == null) {
            context.addMessage(null, new FacesMessage("Внимание", "Поле логин и пароль не могут быть пустым"));
        } else if (username == null && password != null) {
            context.addMessage(null, new FacesMessage("Внимание", "Поле логин не может быть пустым"));
        } else if (username != null && password == null) {
            context.addMessage(null, new FacesMessage("Внимание", "Поле пароль не может быть пустым"));
        } else {
            try {
                Users user = (Users) getEntityManager().createNamedQuery("Users.findByUsersLoginAndPassword")
                        .setParameter("login", username)
                        .setParameter("password", password)
                        .getSingleResult();
                if (user != null) {
                    if (user.getLogin().equals("ADMIN")) {
                        admin = true;
                    } else {
                        manager = true;
                    }
                    
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);//session
                    
                    String username = ((Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).getLogin();
                   
                    userTransaction.begin();
                  
                    userTransaction.commit();
                    System.out.println("redirect");
                    redirect("/view/rating.xhtml");
                }
            } catch (javax.persistence.NoResultException e) {
                context.addMessage(null, new FacesMessage("Внимание", "Такого пользователя не существует. Проверьте пароль и логин"));
            } catch (NotSupportedException ex) {
                Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RollbackException ex) {
                Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicMixedException ex) {
                Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (HeuristicRollbackException ex) {
                Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalStateException ex) {
                Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Users checkUser() {//check existing user
        Users test = (Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if (test != null) {
            return test;
        }
        return null;
    }

    public void welcomeListener() throws Exception {//redirect to login page when not auth users
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
    }

    public void logout() {
        try {
            Users test = (Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
          
            if (test != null) {
                
                userTransaction.begin();
              
                userTransaction.commit();
            }
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        } catch (IOException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotSupportedException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void redirect(String path) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + path);
        } catch (IOException ex) {
            Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redirectToRating() {
        redirect("/view/rating.xhtml");
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isManager() {
        return manager;
    }

}
