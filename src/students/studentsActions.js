/* Acoes de Students */
import axios from 'axios'

const BASE_URL = 'https://jsonplaceholder.typicode.com';

export function getAllStudents() {
  const request = axios.get(`${BASE_URL}/users`);

  return {
    type: 'STUDENTS_FETCHED',
    payload: request
  }
}
