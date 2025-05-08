import axios from 'axios';
import { Estado } from '../../../app/(main)/cadastros/estados/page';

export class EstadoService {

    url = process.env.NEXT_PUBLIC_URL_API;

    constructor() {
        console.log('API URL:', this.url);
    }

    buscarTodos() {
        return axios.get<Estado[]>(this.url + '/estado/');
    }

    salvar(objeto: Estado) {
        return axios.post(this.url + '/estado/', objeto);
    }

    editar(objeto: Estado) {
        console.log('Objeto antes de editar:', objeto);
        const url = this.url + '/estado/' + objeto.id;
        console.log('URL de edição:', url);
        return axios.put(url, objeto);
    }

    excluir(id: string | number) {
        return axios.delete(this.url + '/estado/' + id);
    }
}
