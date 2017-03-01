package br.senai.sp.informatica.todolist.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Tecnico_Manha on 01/03/2017.
 */

public class RestUtil {

    private static String readStream(InputStream inputStream) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String linha = null;
            while ((linha = reader.readLine()) != null) {
                builder.append(linha + "\n");
            }
        } catch (Exception erro) {
            throw new RuntimeException("Erro: " + erro.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception erro2) {
                    throw new RuntimeException("Erro: " + erro2.getMessage());
                }
            }
        }
        return builder.toString();
    }

    public static void post(String json, String url, Context context) throws Exception {
        if (isConexaoDisponivel(context)) {
            URL endereco = new URL(url);
            HttpURLConnection conexao = (HttpURLConnection) endereco.openConnection();
            conexao.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conexao.setRequestMethod("POST");
            conexao.setDoOutput(true);
            conexao.connect();
            OutputStream out = conexao.getOutputStream();
            out.write(json.getBytes("UTF-8"));
            out.flush();
            out.close();
            int status = conexao.getResponseCode();
            if (status >= HttpsURLConnection.HTTP_BAD_REQUEST) {
                throw new Exception("Erro: " + status);
            } else {

            }
        } else {
            throw new RuntimeException("SEM CONEXÃO");
        }
    }

    public static boolean isConexaoDisponivel(Context context) {
        try {
            ConnectivityManager connectivity =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity == null) {
                return false;
            } else {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
