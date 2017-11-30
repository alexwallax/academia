package academia.com.br.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import academia.com.br.models.Cliente;

public class ClienteDao extends SQLiteOpenHelper {

        public ClienteDao(Context context) { super(context, "Agenda", null, 1); }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "";
            sql += "CREATE TABLE Clientes(";
            sql += "id INTEGER PRIMARY KEY, ";
            sql += "nome TEXT, ";
            sql += "telefone TEXT, ";
            sql += "peso REAL, ";
            sql += "altura REAL";
            sql += ");";
            db.execSQL(sql);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {}

        private ContentValues pegarDadosClientes(Cliente cliente) {
            ContentValues values = new ContentValues();
            values.put("nome", cliente.getNome());
            values.put("telefone", cliente.getTelefone());
            values.put("peso", cliente.getPeso());
            values.put("altura", cliente.getAltura());
            return values;
        }

        public void inserir(Cliente cliente) {
            SQLiteDatabase db = getWritableDatabase();
            db.insert("Clientes", null, pegarDadosClientes(cliente));
        }

        public void editar(Cliente cliente) {
            SQLiteDatabase db = getWritableDatabase();
            String where = "id = ?";
            String [] params = {cliente.getId().toString()};
            db.update("Clientes", pegarDadosClientes(cliente), where, params);
        }

        public void deletar(Cliente cliente) {
            SQLiteDatabase db = getWritableDatabase();
            String where = "id = ?";
            String [] params = {cliente.getId().toString()};
            db.delete("Clientes", where, params);
        }

        public List<Cliente> buscarTodos() {
            SQLiteDatabase db = getReadableDatabase();
            String sql = "SELECT * FROM Clientes";
            Cursor cursor = db.rawQuery(sql, null);
            List<Cliente> clientes = new ArrayList<Cliente>();
            while (cursor.moveToNext()) {
                Cliente cliente = new Cliente();
                cliente.setId(cursor.getInt(cursor.getColumnIndex("id")));
                cliente.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                cliente.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
                cliente.setPeso(cursor.getString(cursor.getColumnIndex("peso")));
                cliente.setAltura(cursor.getString(cursor.getColumnIndex("altura")));
                clientes.add(cliente);
            }
            cursor.close();
            return clientes;
        }



    }













