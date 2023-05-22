<template>

    <v-card outlined>
        <v-card-title>
            CreateTask
        </v-card-title>

        <v-card-text>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
            <Date label="DueDate" v-model="value.dueDate" :editMode="editMode"/>
            <String label="Priority" v-model="value.priority" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createTask"
            >
                CreateTask
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CreateTaskCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.description = '';
            this.value.dueDate = '2023-05-22';
            this.value.priority = '';
        },
        watch: {
        },
        methods: {
            createTask() {
                this.$emit('createTask', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

