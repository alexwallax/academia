package academia.com.br.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import academia.com.br.R;
import academia.com.br.models.Cliente;

public class ClienteAdapter extends BaseAdapter {

    private List<Cliente> clientes;
    private Context context;

    public ClienteAdapter(Context context, List<Cliente> clientes) {
        this.clientes = clientes;
        this.context = context;
    }

    @Override
    public int getCount() {return this.clientes.size(); }

    @Override
    public Object getItem(int posicao) {
        return this.clientes.get(posicao);
    }

    @Override
    public long getItemId(int posicao) {return this.clientes.get(posicao).getId(); }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View moldura = inflater.inflate(R.layout.item_lista, null);

        TextView campoNome = (TextView) moldura.findViewById(R.id.lista_nome);
        TextView campoTelefone = (TextView) moldura.findViewById(R.id.lista_telefone);

        Cliente cliente = (Cliente) getItem(posicao);

        campoNome.setText(cliente.getNome());
        campoTelefone.setText(cliente.getTelefone());

        return moldura;
    }
}

















