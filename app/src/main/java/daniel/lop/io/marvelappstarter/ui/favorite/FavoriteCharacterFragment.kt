package daniel.lop.io.marvelappstarter.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import daniel.lop.io.marvelappstarter.databinding.FragmentFavoriteCharacterBinding
import daniel.lop.io.marvelappstarter.ui.base.BaseFragment

@AndroidEntryPoint
class FavoriteCharacterFragment :
    BaseFragment<FragmentFavoriteCharacterBinding, FavoriteViewModel>() {

    override val viewModel: FavoriteViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteCharacterBinding =
        FragmentFavoriteCharacterBinding.inflate(inflater, container, false)
}