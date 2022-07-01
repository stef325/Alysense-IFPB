import ApiService from "./ApiService";

export default class EventApiService extends ApiService{
    constructor(){
        super('/event');
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

    findAll(){
        return this.get(`/all`);
    }

    findById(id){
        return super.get(`/${id}`);
    }

};