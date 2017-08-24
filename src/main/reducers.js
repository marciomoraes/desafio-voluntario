/* Arquivo que importa todos os reducers da aplicação */
import { combineReducers } from 'redux';

import StudentsReducer from '../students/studentsReducer'

const rootReducer = combineReducers({
  students: StudentsReducer
});

export default rootReducer;
