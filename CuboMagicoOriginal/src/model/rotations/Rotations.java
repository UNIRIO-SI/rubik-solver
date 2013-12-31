package model.rotations;

import model.cubos.CuboMagico;

public interface Rotations {
        
        public void girarCimaSentidoHorario(CuboMagico cubo);
        
        public void girarCimaSentidoAntiHorario(CuboMagico cubo);
        
        public void girarCima2Vezes(CuboMagico cubo);
        
        public void girarBaseSentidoHorario(CuboMagico cubo);
        
        public void girarBaseSentidoAntiHorario(CuboMagico cubo);
        
        public void girarBase2Vezes(CuboMagico cubo);
        
        public void girarFrenteSentidoHorario(CuboMagico cubo);
        
        public void girarFrenteSentidoAntiHorario(CuboMagico cubo);
        
        public void girarFrente2Vezes(CuboMagico cubo);
        
        public void girarAtrasSentidoHorario(CuboMagico cubo);
        
        public void girarAtrasSentidoAntiHorario(CuboMagico cubo);
        
        public void girarAtras2Vezes(CuboMagico cubo);
        
        public void girarDireitaSentidoHorario(CuboMagico cubo);
        
        public void girarDireitaSentidoAntiHorario(CuboMagico cubo);
        
        public void girarDireita2Vezes(CuboMagico cubo);
        
        public void girarEsquerdaSentidoHorario(CuboMagico cubo);
        
        public void girarEsquerdaSentidoAntiHorario(CuboMagico cubo);
        
        public void girarEsquerda2Vezes(CuboMagico cubo);
        
        public void girarCamadaMeioHorizontalSentidoHorario(CuboMagico cubo);
        
        public void girarCamadaMeioHorizontalSentidoAntiHorario(CuboMagico cubo);
        
        public void girarCamadaMeioHorizontal2Vezes(CuboMagico cubo);
        
        public void girarEixoXSentidoHorario(CuboMagico cubo);
        
        public void girarEixoXSentidoAntiHorario(CuboMagico cubo);
        
        public void girarEixoX2Vezes(CuboMagico cubo);
        
        public void girarEixoYSentidoHorario(CuboMagico cubo);
        
        public void girarEixoYSentidoAntiHorario(CuboMagico cubo);
        
        public void girarEixoY2Vezes(CuboMagico cubo);
        
        public void girarEixoZSentidoHorario(CuboMagico cubo);
        
        public void girarEixoZSentidoAntiHorario(CuboMagico cubo);
        
        public void girarEixoZ2Vezes(CuboMagico cubo);
        
        public void executa(CuboMagico cubo, String [] operacoes);
        
}
