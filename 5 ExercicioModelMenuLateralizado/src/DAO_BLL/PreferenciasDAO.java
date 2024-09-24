package DAO_BLL;

import Model.PreferenciasVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class PreferenciasDAO {
    Boolean resultado = false;

    public DefaultListModel<String> BancoConectado() throws Exception {
        Connection con = DB_DAO.getInstancia().getConexao();
        try {
            DefaultListModel<String> modelo = new DefaultListModel<String>();

            StringBuilder strSql = new StringBuilder();

            strSql.append("SELECT");
            strSql.append(" Descricao");
            strSql.append(" FROM");
            strSql.append(" Preferencias_3");

            PreparedStatement psql = con.prepareStatement(strSql.toString());

            ResultSet rsPreferencias = psql.executeQuery();

            while (rsPreferencias.next()) {
                modelo.addElement(rsPreferencias.getString("Descricao"));
            }

            return modelo;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (con != null) {
                try {
                    DB_DAO.getInstancia().closeConexao();
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
    }

    public DefaultListModel<String> BancoDesconectado() throws Exception {
        Connection con = DB_DAO.getInstancia().getConexao();
        try {
            DefaultListModel<String> modelo = new DefaultListModel<String>();

            StringBuilder strSql = new StringBuilder();

            strSql.append("SELECT");
            strSql.append(" Descricao");
            strSql.append(" FROM");
            strSql.append(" Preferencias_3");

            PreparedStatement psql = con.prepareStatement(strSql.toString());

            ResultSet rsPreferencias = psql.executeQuery();

            ArrayList<String> lista = new ArrayList<String>();

            while (rsPreferencias.next()) {
                lista.add(rsPreferencias.getString("Descricao"));
            }

            DB_DAO.getInstancia().closeConexao();

            lista.forEach(linhaArquivo -> {
                modelo.addElement(linhaArquivo);
            });

            return modelo;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public ResultSet ConsultarBD() throws Exception {
        Connection con = DB_DAO.getInstancia().getConexao();
        try {
            StringBuilder strSql = new StringBuilder();
            strSql.append("SELECT");
            strSql.append(" ID,");
            strSql.append(" Descricao");
            strSql.append(" FROM");
            strSql.append(" Preferencias_3");
            PreparedStatement psql = con.prepareStatement(strSql.toString());
            ResultSet rsPreferencias = psql.executeQuery();

            return rsPreferencias;

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (con != null) {
                try {
                    DB_DAO.getInstancia().closeConexao();
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
    }

    public Boolean InserirBD(PreferenciasVO preferencia) throws Exception {
        Connection con = DB_DAO.getInstancia().getConexao();
        try {
            StringBuilder strSql = new StringBuilder();
            strSql.append("INSERT");
            strSql.append(" INTO");
            strSql.append(" Preferencias_3 (");
            strSql.append(" Descricao");
            strSql.append(" ) VALUES (");
            strSql.append(" ?");
            strSql.append(" )");
            PreparedStatement psql = con.prepareStatement(strSql.toString());
            psql.setString(1, preferencia.getDescricao());

            if (psql.executeUpdate() > 0) {
                resultado = true;
            } else {
                resultado = false;
            }

            return resultado;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (con != null) {
                try {
                    DB_DAO.getInstancia().closeConexao();
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
    }

    public Boolean ExcluirBD(PreferenciasVO preferencia) throws Exception {
        Connection con = DB_DAO.getInstancia().getConexao();
        try {
            StringBuilder strSql = new StringBuilder();
            strSql.append("DELETE");
            strSql.append(" FROM");
            strSql.append(" Preferencias_3");
            strSql.append(" WHERE");
            strSql.append(" ID = ?");
            PreparedStatement psql = con.prepareStatement(strSql.toString());
            psql.setInt(1, preferencia.getId());

            if (psql.executeUpdate() > 0) {
                resultado = true;
            } else {
                resultado = false;
            }

            return resultado;

        } catch (Exception ex) {
            throw ex;
        } finally {
            if (con != null) {
                try {
                    DB_DAO.getInstancia().closeConexao();
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
    }

    public Boolean AlterarBD(PreferenciasVO preferencia) throws Exception {
        Connection con = DB_DAO.getInstancia().getConexao();
        try {
            StringBuilder strSql = new StringBuilder();
            strSql.append("UPDATE");
            strSql.append(" Preferencias_3");
            strSql.append(" SET");
            strSql.append(" Descricao = ?");
            strSql.append(" WHERE");
            strSql.append(" ID = ?");

            PreparedStatement psql = con.prepareStatement(strSql.toString());
            psql.setString(1, preferencia.getDescricao());
            psql.setInt(2, preferencia.getId());

            if (psql.executeUpdate() > 0) {
                resultado = true;
            } else {
                resultado = false;
            }

            return resultado;
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (con != null) {
                try {
                    DB_DAO.getInstancia().closeConexao();
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
    }
}