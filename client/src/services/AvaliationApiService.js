import ApiService from "./ApiService";

export default class AvaliationApiService extends ApiService{
    constructor(){
        super('/avaliation');
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