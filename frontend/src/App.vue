<template>
    <div id="app">
        <h1 class="text-center">Список городов</h1>
        <div class="m-4">
            <table class="table table-bordered table-sm">
                <thead>
                <tr>
                    <th style="width: 5%;">ID</th>
                    <th style="width: 25%;">Наименование города</th>
                    <th style="width: 50%;">Краткое описание города</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr :key="city.id + 1" v-for="city in cities">
                    <td>{{ city.id }}</td>
                    <td>{{ city.name }}</td>
                    <td>{{ city.info }}</td>
                    <td>
                        <b-button @click="open_city(city)" class="mr-2" size="sm" v-b-modal.modal variant="primary">
                            Открыть
                        </b-button>
                        <b-button @click="delete_city(city)" size="sm" variant="danger">Удалить</b-button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="m-4 align-content-end">
            <b-button @click="create_city" v-b-modal.modal variant="primary">Создать</b-button>
        </div>
        <b-modal :title="'Город. ID ' + this.current_city.id" @ok="doAction" id="modal" ok-only>
            <b-form>
                <b-form-group>
                    <h6>Название города</h6>
                    <b-form-input placeholder="Имя" type="text" v-model="current_city.name"/>
                </b-form-group>
                <b-form-group>
                    <h6>Краткое описание</h6>
                    <b-form-textarea placeholder="Описание" rows="4" v-model="current_city.info"/>
                </b-form-group>
            </b-form>
        </b-modal>
    </div>
</template>

<script>
    import Axios from "axios";

    export default {
        name: 'App',
        data() {
            return {
                current_city: {},
                cities: []
            }
        },
        methods: {
            open_city: function (city) {
                this.current_city = city;
            },
            create_city: function () {
                this.current_city = {id: -1, name: '', info: ''};
            },
            doAction: function () {
                Axios.post('admin/city/save/' + this.current_city.id, this.current_city)
                    .then(() => {
                        this.fill_data();
                        console.log('post successful')
                    })
                    .catch(reason => console.log(reason.message));
            },
            delete_city: function (city) {
                Axios.delete('admin/city/delete/' + city.id)
                    .then(() => {
                        this.fill_data();
                        console.log('delete successful')
                    })
                    .catch(reason => console.log(reason.message));
            },
            fill_data: function () {
                Axios.get("admin/cities")
                    .then(response => {
                        if (response.data.length !== 0) {
                            this.cities = response.data;
                        } else {
                            this.cities = [{id: null, name: 'нет данных', info: ''}]
                        }
                    })
                    .catch(reason => console.log(reason.message))
            }
        },
        mounted() {
            this.fill_data();
        },
        components: {}
    }
</script>
