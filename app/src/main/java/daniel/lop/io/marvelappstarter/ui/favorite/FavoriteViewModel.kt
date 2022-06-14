package daniel.lop.io.marvelappstarter.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import daniel.lop.io.marvelappstarter.data.model.character.CharacterModel
import daniel.lop.io.marvelappstarter.repository.MarvelRepository
import daniel.lop.io.marvelappstarter.ui.ResourceState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {

    private val _favorites =
        MutableStateFlow<ResourceState<List<CharacterModel>>>(ResourceState.Empty())
    val favorites: StateFlow<ResourceState<List<CharacterModel>>> = _favorites

    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch {
        repository.getAll().collectLatest { characters ->
            if (characters.isNullOrEmpty()) {
                _favorites.value = ResourceState.Empty()
            } else {
                _favorites.value = ResourceState.Success(characters)
            }
        }
    }

    fun delete(characterModel: CharacterModel) = viewModelScope.launch {
        repository.delete(characterModel)
    }
}