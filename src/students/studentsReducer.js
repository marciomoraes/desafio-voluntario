/* Reducer de Dashboard */
const INITIAL_STATE = {
  students: []
}

// exporta o state
export default function(state = INITIAL_STATE, action) {
  switch(action.type) {
    case 'STUDENTS_FETCHED':
      return { ...state, students: action.payload.data } // replica o state e altera a variavel students baseado no retorno
    default:
      return state;
  }
}
