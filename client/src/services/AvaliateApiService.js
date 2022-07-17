import ApiService from "./ApiService";

export default class AvaliationApiService extends ApiService{
    constructor(){
        super('/evaluete_item');
    }

    create(object){
        return this.post('',object);
    }

    update(id,object){
        return this.put(`/${id}`,object);
    }

    delete(id){
        return super.delete(`/${id}`);
    }

    find(params){
        return this.get(`${params}`);
    }

};