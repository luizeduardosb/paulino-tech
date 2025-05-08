import axios from 'axios';
import { Categoria } from '../../../app/(main)/cadastros/categorias/page';

export class CategoriaService {

    url = process.env.NEXT_PUBLIC_URL_API;

    constructor() {
        console.log('API URL:', this.url);
    }

    buscarTodos() {
        return axios.get<Categoria[]>(this.url + '/categoria/');
    }

    salvar(objeto: Categoria) {
        return axios.post(this.url + '/categoria/', objeto);
    }

    editar(objeto: Categoria) {
        console.log('Objeto antes de editar:', objeto);
        const url = this.url + '/categoria/' + objeto.id;
        console.log('URL de edição:', url);
        return axios.put(url, objeto);
    }

    excluir(id: string | number) {
        return axios.delete(this.url + '/categoria/' + id);
    }
}
