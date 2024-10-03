package com.DSI.TP1.services;

import java.util.List;

import com.DSI.TP1.Entities.Livre;

public interface IServiceLivre {

    public List<Livre> getAllLivre();
    public Livre findLivre(int id);
    public boolean saveLivre(Livre livre);
    public boolean deletLivre(int id);
    public Livre updateLivre(Livre livre, int id);
}